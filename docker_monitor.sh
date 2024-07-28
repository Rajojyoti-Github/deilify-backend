#!/bin/bash

services_dirs=(
  "del-backend-deliveryservice"
  "del-backend-ordermanagementservice"
  "del-backend-userservice"
  "del-backend-vendorservice"
)

services=(
  "deilify-backend-ordermanagementservice-1"
  "deilify-backend-deliveryservice-1"
  "deilify-backend-userservice-1"
  "deilify-backend-vendorservice-1"
)

build_services() {
  for dir in "${services_dirs[@]}"; do
    echo "Navigating to $dir and running mvn clean install..."
    (cd $dir && mvn clean install)
  done
}

restart_exited_services() {
  for service in "${services[@]}"; do
    echo "Checking status for $service..."
    status=$(docker inspect -f '{{.State.Status}}' $service 2>&1)
    echo "Status for $service: $status"

    if [[ "$status" == "exited" ]]; then
      echo "Service $service is in exited state. Restarting..."
      docker start $service 2>&1
      if [ $? -ne 0 ]; then
        echo "Failed to restart $service. Please check the logs."
      else
        echo "Service $service has been restarted."
      fi
    else
      echo "Service $service is in state: $status"
    fi
  done
}


print_service_logs() {
  for service in "${services[@]}"; do
    echo "Logs for $service:"
    docker compose logs $service
    echo "--------------------------------------------------"
  done
}

echo "Running docker compose up..."
docker compose up -d
sleep 10
restart_exited_services
print_service_logs
