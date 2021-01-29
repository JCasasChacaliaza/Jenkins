.PHONY: build test run logs stop start down

include dev.env
export


build:
	gradlew build

test:
	gradlew test

run:
	make down
	make build
	docker-compose up --build -d
	make logs

logs:
	docker-compose logs -f

stop:
	docker-compose stop

start:
	docker-compose start
	make logs

restart:
	docker-compose restart
	make logs

down:
	docker-compose down
