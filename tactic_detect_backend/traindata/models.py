from django.db import models


# Create your models here.
class Authenticate(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Authorize(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Cache(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Checkpoint(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Fifo(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Heartbeat(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Pingecho(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Priority(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Redundancy(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()


class Voting(models.Model):
    user_id = models.IntegerField(primary_key=True, auto_created=True)
    text = models.CharField(max_length=1000, default='')
    label = models.IntegerField()
