import { Genre } from "./genre";
import { Publisher } from "./publisher";
import { Author } from "../author/author";

export class Book{
id:number    
name:string;
translatorName:string;
genre:Genre;    
publicationDate:string;
pages:string;
language:string;
stockQuantity:number;
price:number;
publisher:Publisher;
author:Author;

}