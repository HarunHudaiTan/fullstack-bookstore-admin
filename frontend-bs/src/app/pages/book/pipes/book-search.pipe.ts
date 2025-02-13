import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../book';

@Pipe({
  name: 'bookSearch',
  standalone: true
})
export class BookSearchPipe implements PipeTransform {
  transform(books: Book[], searchText: string): Book[] {
    if (!books) return [];
    if (!searchText) return books;

    searchText = searchText.toLowerCase();

    return books.filter(book => {
      return (
        book.name?.toLowerCase().includes(searchText) ||
        book.translatorName?.toLowerCase().includes(searchText) ||
        book.author?.firstName?.toLowerCase().includes(searchText) ||
        book.author?.lastName?.toLowerCase().includes(searchText) ||
        book.genre?.name?.toLowerCase().includes(searchText) ||
        book.genre?.description?.toLowerCase().includes(searchText) ||
        book.pages?.toString().includes(searchText) ||
        book.language?.toLowerCase().includes(searchText) ||
        book.publisher?.name?.toLowerCase().includes(searchText) ||
        book.publicationDate?.toString().includes(searchText)
      );
    });
  }
} 