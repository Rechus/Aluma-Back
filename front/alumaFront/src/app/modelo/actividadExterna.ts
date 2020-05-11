import { Actividad } from './actividad';
export interface ActividadExterna {
    nombre: string;
    fecha: Date;
    numeroPlazas: number;
    precio: number;
    listaParticipantes: object[];
    listaReserva: object[];
    reservaPlazasEmpleados: number;
    destino: string;
}