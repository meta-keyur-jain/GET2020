import { TodoService } from './../../services/todo.service';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Todo } from '../../models/Todo';
@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit {
  @Output() deleteTodos:EventEmitter<any> = new EventEmitter();
  todos:Todo[];
  
  constructor(private todoService:TodoService) { }

  ngOnInit(): void {
   this.todos = this.todoService.getTodos()
  }

  deleteTodo(todo:Todo){
    console.log(todo)
    this.todos = this.todos.filter(t=>t.id!==todo.id)
    //this.deleteTodos.emit(this.todos);
    this.todoService.deleteTodos(todo);
  }
  addTodo(todo:Todo){
    console.log(todo);
    this.todoService.addTodo(todo);
  }
}
