import os

from flask import Flask
from redis import Redis


app = Flask(__name__)
redis = Redis(host=os.environ['REDIS_HOST'], port=os.environ['REDIS_PORT'])
bind_port = int(os.environ['BIND_PORT'])
bind_port2 = int(os.environ['BIND_PORT2'])
bind_port3 = int(os.environ['BIND_PORT3'])

@app.route('/')
def hello():
    redis.incr('hits')
    total_hits = redis.get('hits').decode()
    return f'Hello from Redis! I have been seen {total_hits} times!!!'

# hola como les va!!!
if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True, port=bind_port)
