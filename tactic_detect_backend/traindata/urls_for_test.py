from django.conf.urls import url
# from .views_upload_single import *
from rest_framework.decorators import api_view


@api_view(['POST', ])
def upload_authenticate(request):
    print(request.data)


urlpatterns = [
    url(r'restoremethod', upload_authenticate),
]
