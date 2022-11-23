import json

from django.http import HttpResponse
from .Utils import predict


def tactic_name(request):
    post_request = request.get_host()
    print('post is {}'.format(post_request))

    if request.method == 'POST':
        print('current method is {}'.format(request.method))

        post_itself = request.POST
        print('request POST is ', end='')
        print(post_itself)

        post_body = request.body
        print('request body is ', end='')
        print(post_body)

        # 解析JSON数据 应该为要处理的train.csv路径
        json_result = json.loads(post_body)
        print('json_result is ', end='')
        print(json_result)
        file_position = json_result['position']
        result = predict.predict(file_position)
    elif request.method == 'GET':
        print('current method is {}'.format(request.method))

    return HttpResponse(result)

