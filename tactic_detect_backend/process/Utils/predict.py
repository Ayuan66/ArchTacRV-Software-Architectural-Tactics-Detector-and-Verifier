import json


def predict(file_position):
    file = open(file_position, 'r')
    result = {}
    for line in file.readlines():
        line = str(line).replace("\n", "")
        temp = line.split('\t', 1)[0].strip()
        result[temp] = line.split('\t', 1)[1]
    file.close()
    print(result)
    json_result = json.dumps(result)
    return json_result


if __name__ == '__main__':
    predict('C:\\Users\\Dell\\Downloads\\SoftwareAnalysisAndTest\\tactic\\NewIDEA\\result\\adaboost_result.txt')
