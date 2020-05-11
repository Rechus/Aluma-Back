export interface Actividad{
    nombre: string;
    fecha: Date;
    numeroPlazas: number;
    precio: number;
    listaParticipantes: object[];
    listaReserva: object[];
    reservaPlazasEmpleados: number;
}