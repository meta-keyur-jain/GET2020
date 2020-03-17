//queue class
Queue = function() {
    this.items = [];

    //adding item to queue
    this.enque = function(data) {
        this.items.push(data);
    }

    //deleting item from queue
    this.deque = function() {
        if (this.items.length == 0) {
            console.log("Underflow");
        } else {
            this.items.shift();
        }
    }

    //show queue
    this.show = function() {
        for (var index = 0; index < this.items.length; index++) {
            console.log(this.items[index]);
        }
    }
}