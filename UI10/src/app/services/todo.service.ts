import { Injectable } from '@angular/core';
import {Todo} from '../models/Todo'
import { from } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  newTodo:Todo[];
  id:number=3;
  status:'new';
  constructor() { 
    this.newTodo = [{
      id:1,
    title:'first heading',
    completed:false,
    description:'This is my first heading',
    creationDate:new Date(),
    completionDate:new Date(),
    priority:'high',
    status:'new'

    },
    {
      id:2,
      title:'second heading',
      completed:true,
      description:'This is my second heading',
      creationDate:new Date(),
      completionDate:new Date(),
      priority:'medium',
      status:'inprogress'
    },{
      id:3,
      title:'third heading',
      completed:false,
      description:'This is my third heading',
      creationDate:new Date(),
      completionDate:new Date(),
      priority:'low',
      status:'complete'
  
    },]
  }

  
  deleteTodos(todo:Todo){
  
    if(todo.id>3){
      console.log(this.id)
      --this.id;
      console.log(this.id)
    }
  }
  addTodo(todo:Todo){
    todo.id = ++this.id;
    todo.status='new';
    this.newTodo.push(todo);
  }
  getTodos(){
    return this.newTodo;
  }
}
