import { MaterialModule } from './../../material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputTextComponent } from './input-text/input-text.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputDateComponent } from './input-date/input-date.component';
import { InputNumberComponent } from './input-number/input-number.component';
import { InputSelectComponent } from './input-select/input-select.component';
import { InputTextareaComponent } from './input-textarea/input-textarea.component';


@NgModule({
  declarations: [
    InputTextComponent,
    InputDateComponent,
    InputNumberComponent,
    InputSelectComponent,
    InputTextareaComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule
  ],
  exports: [
    InputTextComponent,
    InputDateComponent,
    InputNumberComponent,
    InputSelectComponent,
    InputTextareaComponent
  ]
})
export class CampoModule { }
