import { MaterialModule } from './material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AlertaComponent } from './components/alerta/alerta.component';



@NgModule({
  declarations: [AlertaComponent],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [AlertaComponent]
})
export class SharedModule { }
