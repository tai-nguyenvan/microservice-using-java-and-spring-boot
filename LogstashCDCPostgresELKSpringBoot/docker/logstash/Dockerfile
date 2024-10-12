# Use the official Logstash image
FROM docker.elastic.co/logstash/logstash:8.15.1

# Copy the Logstash configuration file to the container
COPY ./config/logstash-config.conf /usr/share/logstash/pipeline/logstash-config.conf
COPY ./drivers/postgresql-42.7.1.jar /usr/share/logstash/drivers/postgresql-42.7.1.jar
