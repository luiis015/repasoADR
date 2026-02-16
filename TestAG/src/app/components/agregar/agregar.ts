import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { LibroService } from '../../services/libro.service';

@Component({
  selector: 'app-agregar',
  standalone: false,
  templateUrl: './agregar.html',
  styleUrl: './agregar.css'
})
export class AgregarComponent {
  nombre: string = '';
  autor: string = '';
  genero: string = '';
  generosDisponibles: string[] = [];

  constructor(private libroService: LibroService) {
    this.generosDisponibles = this.libroService.getGenerosArray();
  }

  agregarLibro() {
    if (!this.nombre || !this.autor || !this.genero) {
      Swal.fire({
        title: 'Error',
        text: 'Por favor, rellena todos los campos',
        icon: 'error',
        draggable: true
      });
      return;
    }

    this.libroService.agregarLibro({
      id: 0,
      nombre: this.nombre,
      autor: this.autor,
      genero: this.genero
    });

    Swal.fire({
      title: '¡Libro agregado!',
      text: `El libro "${this.nombre}" se ha agregado correctamente`,
      icon: 'success',
      draggable: true
    });

    this.limpiarFormulario();
  }

  limpiarFormulario() {
    this.nombre = '';
    this.autor = '';
    this.genero = '';
  }
}