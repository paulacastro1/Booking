export class UserModel {
    client_id: number;
    password: string;
    id_type: string;
    client_name: string;
    cellphone: string;

    constructor()
    {
        this.client_id = 0;
        this.password = '';
        this.id_type = '';
        this.client_name = '';
        this.cellphone = '';
    }
}