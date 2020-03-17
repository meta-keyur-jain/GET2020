 //structure of link list
 Node = function(data) {
     this.data = data;
     this.next = null;
 }

 //implementation of linklist
 linkList = function() {

     this.head = null;
     this.size = 0;

     //Add element to link list
     this.add = function(data) {

             //new node
             var node = new Node(data);

             //current node
             var current;

             //if link list is empty the make the node to first element
             if (this.head == null) {
                 this.head = node;
             } else {
                 current = this.head;


                 //itetrate to end of list
                 while (current.next) {
                     current = current.next;
                 }

                 //add the node
                 current.next = node;
             }
             this.size++;

         }
         //delete element in link list
     this.delete = function(data) {
         var current = this.head;
         var prev = null;
         while (current != null) {
             if (current.data == data) {
                 if (prev == null) {
                     this.head = current.next;
                 } else {
                     prev.next = current.next;
                 }
                 this.size--;
                 return current.data;
             }
             prev = current;
             current = current.next;
         }
         return -1;
     }

     //Total element in list
     this.sizeList = function() {
         console.log(size)
     }

     //show link list
     this.show = function() {
         var current = this.head;
         while (current != null) {
             console.log(current.data);
             current = current.next;

         }

     }
 }