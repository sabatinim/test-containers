FROM debian
RUN apt-get update && apt-get --no-install-recommends install -y gettext-base default-mysql-client

COPY . /
CMD ["/entrypoint.sh"]