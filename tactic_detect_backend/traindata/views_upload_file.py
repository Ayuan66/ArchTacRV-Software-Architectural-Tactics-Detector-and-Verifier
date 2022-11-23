# 前端传送文件绝对路径的情况
import json

import numpy
from rest_framework.decorators import api_view
from rest_framework.response import Response
import joblib
import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer

from Detection.buffer import data_process
import csv
import os

model_dict = {
    'pingecho': 'Pingecho',
    'voting': 'Voting',
    'fifo': 'Fifo',
    'redundancy': 'Redundancy',
    'checkpoint': 'Checkpoint',
    'heartbeat': 'Heartbeat',
    'cache': 'Cache',
    'priority': 'Priority',
    'authorize': 'Authorize',
    'authenticate': 'Authenticate',
}
model_dict_reverse = {k: v for v, k in model_dict.items()}

pingecho_dict = {1: 'ping', 2: 'echo', 3: 'notifyException', 4: 'handleException'}
voting_dict = {1: 'request', 2: 'vote', 3: 'failService', 4: 'stopService'}
redundancy_dict = {1: 'request', 2: 'requestService', 3: 'selectResult', 4: 'updateState'}
heartbeat_dict = {1: 'receive', 2: 'alive', 3: 'lost', 4: 'update'}
checkpoint_dict = {1: 'notifyCheckpoint', 2: 'storeCheck', 3: 'failTask', 4: 'rollback', 5: 'commit'}
fifo_dict = {1: 'enqueue', 2: 'dequeue'}
priority_dict = {1: 'request', 2: 'assignPriority', 3: 'enqueue'}

dict_dict = {'pingecho': pingecho_dict, 'voting': voting_dict, 'redundancy': redundancy_dict,
             'heartbeat': heartbeat_dict, 'checkpoint': checkpoint_dict, 'fifo': fifo_dict}


def getname(file_path):
    method_name_list = []
    with open(file_path) as f:
        reader = csv.reader(f)
        next(reader)
        for row in reader:
            text = row[0]
            method_name = text.split(' - ')[0]
            method_name_list.append(method_name)
    return method_name_list


def predict(file_path):
    np.random.seed(500)
    CorpusTrain = data_process.read_csv(file_path)

    # 数据处理
    CorpusTrain = data_process.base_tokenizer(CorpusTrain)
    Train_X = CorpusTrain['text_final']

    # 将数据转化为TF-IDF数据
    tfidf_vector = TfidfVectorizer(max_features=5000).fit(Train_X)
    vector = tfidf_vector.transform(Train_X)

    # 进行预测
    model = joblib.load(os.getcwd() + '/process/models/AdaBoostModel.pkl')
    predictions_NB = model.predict(vector)

    # 获取预测后的不为0的元素下标
    index = numpy.where(predictions_NB != 0)

    # 预测后数组剔除0
    predictions_NB = predictions_NB[predictions_NB != 0]
    print('predict is ')
    print(predictions_NB)
    print('predict length is ', end='')
    print(len(predictions_NB))

    index = index[0]

    # 将下标和预测分类按键值对放于列表中
    result_temp = {}
    for i in range(len(predictions_NB)):
        result_temp[index[i] + 1] = predictions_NB[i]
    result_temp = sorted(result_temp.items(), key=lambda x: x[1], reverse=False)

    # 最后的函数名
    result_name = []

    # 从输入文件中返回函数名
    with open(file_path, 'r') as file:
        reader = csv.reader(file)
        file_to_list = list(reader)
        # 只抽取函数名
        for (key, value) in result_temp:
            name = file_to_list[key][0]
            result_name.append(name.split('-', 1)[0])

    result = {}
    predictions_NB = list(set(predictions_NB))
    predictions_NB = sorted(predictions_NB)
    for label in predictions_NB:
        result[label] = []
    count = 0
    for (position, label) in result_temp:
        result[int(label)].append(result_name[count])
        count += 1

    file = open("adaboost_result.txt", "w")
    for (key, value) in result.items():
        for name in value:
            file.write(name)
            file.write('\t')
            file.write(str(key))
            file.write('\n')
    file.close()

    print('预测结果:\n', result)
    return result


def getResponse(model_name, result):
    d = dict_dict[model_name]
    response = {}
    for key, value in d.items():
        response[value] = []

    for key in result.keys():
        temp_set = set()
        for value in result[key]:
            temp_set.add(value)
        result[key] = list(temp_set)

    for i, item in enumerate(result):
        if item != 0:
            response[d[item]] = result[item]

    final_result = {
        model_name: 'tactic',
    }
    for key, value in response.items():
        for v in value:
            final_result[v] = key

    response = json.dumps(final_result)
    print('response is ' + response)
    return response


def get_project_path(tactic_name):
    # os.path.realpath获取当前脚本的绝对路径
    cur_path = os.path.dirname(os.path.realpath(__file__))
    # 获取当前根项目的路径
    project_path = os.path.dirname(os.path.dirname(cur_path))
    return project_path + '\\tactic_detect_backend' + '\\dataset' + '\\traindata' + '\\' + tactic_name + '\\train.csv'


@api_view(['POST', ])
def upload_authenticate(request):
    filepath = request.data.get('position')
    model_name = 'authenticate'
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_authorize(request):
    filepath = request.data.get('position')
    model_name = 'authorize'
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_cache(request):
    filepath = request.data.get('position')
    model_name = 'cache'
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_checkpoint(request):
    filepath = request.data.get('position')
    model_name = 'checkpoint'
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_fifo(request):
    filepath = request.data.get('position')
    model_name = 'fifo'
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_heartbeat(request):
    model_name = 'heartbeat'
    filepath = get_project_path(model_name)
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_pingecho(request):
    model_name = 'pingecho'
    filepath = get_project_path(model_name)
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_priority(request):
    filepath = request.data.get('position')
    model_name = 'priority'
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_redundancy(request):
    filepath = request.data.get('position')
    model_name = 'redundancy('
    response = getResponse(model_name, predict(filepath))
    return Response(response)


@api_view(['POST', ])
def upload_voting(request):
    filepath = request.data.get('position')
    model_name = 'voting'
    response = getResponse(model_name, predict(filepath))
    return Response(response)
