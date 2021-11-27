FROM debian
RUN apt-get update && apt-get --no-install-recommends install -y gettext-base default-mysql-client

ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

COPY . /
ENTRYPOINT ["/entrypoint.sh"]