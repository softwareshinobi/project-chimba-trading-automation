set -e

set -x

reset

clear

docker-compose -f napkinexchange.yaml down --remove-orphans

docker-compose -f napkinexchange.yaml up