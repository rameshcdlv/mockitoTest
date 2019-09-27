FROM ubuntu:latest
MAINTAINER Akula Ramesh "rameshcdlv@gmail.com"
RUN apt-get update && apt-get install -y openjdk-8-jdk
CMD ["/bin/bash"]