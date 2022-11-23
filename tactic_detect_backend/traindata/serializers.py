from .models import *
from rest_framework import serializers


class AuthenticateSerializers(serializers.ModelSerializer):
    class Meta:
        model = Authenticate
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class AuthorizeSerializers(serializers.ModelSerializer):
    class Meta:
        model = Authorize
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class CacheSerializers(serializers.ModelSerializer):
    class Meta:
        model = Cache
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class CheckpointSerializers(serializers.ModelSerializer):
    class Meta:
        model = Checkpoint
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class FifoSerializers(serializers.ModelSerializer):
    class Meta:
        model = Fifo
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class HeartbeatSerializers(serializers.ModelSerializer):
    class Meta:
        model = Heartbeat
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class PingechoSerializers(serializers.ModelSerializer):
    class Meta:
        model = Pingecho
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class PrioritySerializers(serializers.ModelSerializer):
    class Meta:
        model = Priority
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class RedundancySerializers(serializers.ModelSerializer):
    class Meta:
        model = Redundancy
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')


class VotingSerializers(serializers.ModelSerializer):
    class Meta:
        model = Voting
        fields = ('method_name', 'method_parameter', 'method_return', 'method_call', 'label')
