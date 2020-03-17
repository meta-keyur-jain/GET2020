Stack = function() {
    this.item = [];

    //add to stack
    this.add = function(data) {
        this.item.push(data);
    }

    //remove form stack
    this.delete = function() {
        if (this.item.length == 0) {
            console.log("underflow")
        } else {
            this.item.pop();
        }
    }

    //show the stack
    this.show = function() {
        for (var index = 0; index < this.item.length; index++) {
            console.log(this.item[index]);
        }
    }
}