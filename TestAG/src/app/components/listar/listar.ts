import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { LibroService } from '../../services/libro.service';
import { Libro } from '../../models/libro';

@Component({
  selector: 'app-listar',
  standalone: false,
  templateUrl: './listar.html',
  styleUrl: './listar.css'
})
export class ListarComponent implements OnInit {
  
  generosDisponibles: string[] = [];
  librosFiltrados: Libro[] = [];
  generoSeleccionado: string = 'Todos';

  constructor(private libroService: LibroService) {}

  ngOnInit() {
    this.generosDisponibles = this.libroService.obtenerGenerosUnicos();
    this.librosFiltrados = this.libroService.obtenerLibros();
  }

  filtrar() {
    this.librosFiltrados = this.libroService.obtenerLibrosPorGenero(this.generoSeleccionado);

    if (this.generoSeleccionado !== 'Todos') {
      Swal.fire({
        title: 'Búsqueda completada',
        text: `Se encontraron ${this.librosFiltrados.length} libros de ${this.generoSeleccionado}`,
        icon: 'success',
        draggable: true
      });
    }
  }
}