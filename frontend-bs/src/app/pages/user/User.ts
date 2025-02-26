export class User{
    id:number;
    name: string ;
    surname: string ;
    username: string ;
    password: string ;
    accountNonExpired:boolean;
    accountNonLocked:boolean;
    enabled:boolean;
    credentialsNonExpired:boolean
    authorities:Set<string>;
    accessToken:string;
    refreshToken:string;
}