import { TodoService } from './../../services/todo.service';
import { Component, OnInit,Input,EventEmitter,Output } from '@angular/core';
import {Todo} from '../../models/Todo'
import { from } from 'rxjs';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {

  @Input() todo:Todo;
  @Output() deleteTodo:EventEmitter<Todo> = new EventEmitter();
  
  constructor(private todoServicd:TodoService) { }

  ngOnInit(): void {
  }
  setClasses(){
    let classes = {
      todo:true,
      'para':this.todo.priority==="low",
      'para-1':this.todo.priority==="high",
      'para-2':this.todo.priority==="medium"

    }
    return classes;

  }
  onToggle(todo){
    // console.log("toggle");
    todo.completed = !todo.completed;
  }
  onDelete(todo){
    this.deleteTodo.emit(todo);
  }

}
