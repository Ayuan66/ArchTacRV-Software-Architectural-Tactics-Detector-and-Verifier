# 上传单个数据的函数
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import status
from .serializers import *


@api_view(['POST', ])
def upload_authenticate(request):
    return upload('Authenticate', request.data)


@api_view(['POST', ])
def upload_authorize(request):
    return upload('Authorize', request.data)


@api_view(['POST', ])
def upload_cache(request):
    return upload('Cache', request.data)


@api_view(['POST', ])
def upload_checkpoint(request):
    return upload('Checkpoint', request.data)


@api_view(['POST', ])
def upload_fifo(request):
    return upload('Fifo', request.data)


@api_view(['POST', ])
def upload_heartbeat(request):
    return upload('Heartbeat', request.data)


@api_view(['POST', ])
def upload_pingecho(request):
    return upload('Pingecho', request.data)


@api_view(['POST', ])
def upload_priority(request):
    return upload('Priority', request.data)


@api_view(['POST', ])
def upload_redundancy(request):
    return upload('Redundancy', request.data)


@api_view(['POST', ])
def upload_voting(request):
    return upload('Voting', request.data)


def upload(table, data):
    if table == 'Authenticate':
        serializer = AuthenticateSerializers(data=data)
    elif table == 'Authorize':
        serializer = AuthorizeSerializers(data=data)
    elif table == 'Cache':
        serializer = CacheSerializers(data=data)
    elif table == 'Checkpoint':
        serializer = CheckpointSerializers(data=data)
    elif table == 'Fifo':
        serializer = FifoSerializers(data=data)
    elif table == 'Heartbeat':
        serializer = HeartbeatSerializers(data=data)
    elif table == 'Pingecho':
        serializer = PingechoSerializers(data=data)
    elif table == 'Priority':
        serializer = PrioritySerializers(data=data)
    elif table == 'Redundancy':
        serializer = RedundancySerializers(data=data)
    elif table == 'Voting':
        serializer = VotingSerializers(data=data)
    else:
        serializer = None
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
