import { Injectable } from '@angular/core';
import { Libro } from '../models/libro';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private libros: Libro[] = [
    { id: 1, nombre: 'Don Quijote', autor: 'Miguel de Cervantes', genero: 'Novela' },
    { id: 2, nombre: '1984', autor: 'George Orwell', genero: 'Ciencia Ficción' },
    { id: 3, nombre: 'El Hobbit', autor: 'J.R.R. Tolkien', genero: 'Fantasía' },
    { id: 4, nombre: 'Yo, Robot', autor: 'Isaac Asimov', genero: 'Ciencia Ficción' },
    { id: 5, nombre: 'El Quijote de la Mancha', autor: 'Miguel de Cervantes', genero: 'Novela' },
    { id: 6, nombre: 'El Príncipe', autor: 'Nicolás Maquiavelo', genero: 'Historia' },
    { id: 7, nombre: 'El León, la Bruja y el Ropero', autor: 'C.S. Lewis', genero: 'Infantil' },
    { id: 8, nombre: 'Viaje al Centro de la Tierra', autor: 'Julio Verne', genero: 'Ciencia Ficción' }
  ];

  private contadorId: number = 9;

  constructor() { }

  obtenerLibros(): Libro[] {
    return this.libros;
  }

  obtenerLibrosPorGenero(genero: string): Libro[] {
    if (genero === '' || genero === 'Todos') {
      return this.libros;
    }
    return this.libros.filter(libro => libro.genero === genero);
  }

  obtenerGenerosUnicos(): string[] {
    const generos = this.libros.map(libro => libro.genero);
    return [...new Set(generos)];
  }

  agregarLibro(libro: Libro): void {
    libro.id = this.contadorId++;
    this.libros.push(libro);
  }

  getGenerosArray(): string[] {
    return ['Novela', 'Ciencia Ficción', 'Fantasía', 'Historia', 'Infantil'];
  }
}