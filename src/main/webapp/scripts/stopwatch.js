class Stopwatch {
    start(delay, callback) {
        this.time = Date.now();
        this.count = 0;
        this.interval = setInterval(callback, delay);
    }

    stop() {
        clearInterval(this.interval);
        this.elapsed = Date.now() - this.time;
    }

    getElapsed() {
        return this.elapsed;
    }
}