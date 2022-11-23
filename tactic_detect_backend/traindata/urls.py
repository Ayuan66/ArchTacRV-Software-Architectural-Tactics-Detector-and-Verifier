from django.conf.urls import url
#  如果采用单个数据上传 from .views_upload_single import *
from .views_upload_file import *


urlpatterns = [
    url(r'authenticate', upload_authenticate),
    url(r'authorize', upload_authorize),
    url(r'cache', upload_cache),
    url(r'checkpoint', upload_checkpoint),
    url(r'fifo', upload_fifo),
    url(r'heartbeat', upload_heartbeat),
    url(r'pingecho', upload_pingecho),
    url(r'priority', upload_priority),
    url(r'redundancy', upload_redundancy),
    url(r'voting', upload_voting),
]
