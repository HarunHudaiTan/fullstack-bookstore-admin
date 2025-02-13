export class User{
    name: string ;
    surname: string ;
    username: string ;
    password: string ;
    authorities:Set<string>;
    accessToken:string;
    refreshToken:string;
}