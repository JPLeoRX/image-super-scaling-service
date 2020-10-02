FROM ubuntu:20.04

# Initial setup & install system utils
RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y apt-utils software-properties-common
RUN apt-get install -y vim wget git

# Install Python 3.8 & Pip 3
WORKDIR /
RUN add-apt-repository -y ppa:deadsnakes/ppa
RUN apt-get install -y python3.8
RUN echo "alias python='python3.8'" >> ~/.bashrc
RUN echo "alias python3='python3.8'" >> ~/.bashrc
RUN apt-get install -y python3-pip
RUN echo "alias pip='pip3'" >> ~/.bashrc

# Install Python dependencies
RUN pip3 install flask
RUN pip3 install numpy
RUN pip3 install tensorflow
RUN pip3 install ISR --ignore-installed tensorflow

# Copy source code
RUN mkdir /python-service
COPY . /python-service
WORKDIR /python-service
RUN chmod a+x run.sh

# Run
CMD './run.sh'