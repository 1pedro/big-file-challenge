FROM clojure
COPY . /usr/src/app
COPY big-file.txt /tmp
WORKDIR /usr/src/app
CMD ["lein", "run"]