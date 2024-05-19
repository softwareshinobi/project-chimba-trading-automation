set -e

set -x

reset

clear

docker-compose -f development.yaml up --build
