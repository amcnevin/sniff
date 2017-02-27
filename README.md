# Sniff

#####
Data Collection Framework for using public wifi signals to track walks with the dog.

----
##Goals
1. Capture wifi signals from a handheld or lightweight device (dog collar)
2. Stream data to persistence mechanism
3. Correlate and triangulate timing and signal strength to location
4. Evaluate Dog walking habits.

----
###
Capture

Currently leveraging an onboard wifi adapter of a raspberry pi and using the following shell command:

    iwlist <adapter> scan

This command will be performed on a cron and serialized to a timestamped file.


###
Stream

Using [Nifi](https://nifi.apache.org) to ingest the files, transform them into a defined model for storage. [Spring Boot](https://projects.spring.io/spring-boot/) is used as the container to host a restful webservice for recieving and persisting the data.

###
Storage

Currently using H2 but will most likely scale to postgres and/or ElasticSearch for later updates.

