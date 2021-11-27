#!/bin/bash

case "$@" in
  schema)
    /wait && mysql --host=mysql -uroot -ppwd < employees.sql
    echo "EMPLOYEES schema created!"
  ;;
  demo)
    /wait && mysql --host=mysql -uroot -ppwd < demo.sql
    echo "Could load demo data!"
  ;;
  *)
    exec "$@"
  ;;
esac

