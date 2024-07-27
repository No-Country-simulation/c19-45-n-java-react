"use client";

import { Button, Input, Label } from "../auth";
import { useForm, SubmitHandler } from "react-hook-form";

interface FormValues {
  petname: string;
  species: string;
  petsex: string;
  // Agrega aquí los otros campos de tu formulario
}

export default function InputModal() {
  const { register, handleSubmit } = useForm<FormValues>();

  const onSubmit: SubmitHandler<FormValues> = (data) => {
    console.log(data); //en data sale toda la informacion del registro
  };

  return (
    <div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div>
          <div className="flex items-center justify-between">
            <Label htmlFor="name">Nombre de mascota :</Label>
          </div>
          <div className="mt-2">
            <Input
              name="petname"
              register={register}
              placeholder="nombre de la mascota"
              required
            />
          </div>
        </div>

        <div>
          <div className="flex items-center justify-between">
            <Label htmlFor="especies">Especie :</Label>
          </div>
          <div className="mt-2">
            <Input
              type="name"
              name="species"
              register={register}
              placeholder="nombre de la especie"
            />
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="petsex">Sexo *</Label>
            </div>
            <select className="select w-full max-w-xs" {...register("petsex")}>
              <option disabled selected>
                Seleccione
              </option>
              <option>Macho</option>
              <option>Hembra</option>
            </select>
          </div>
        </div>
        <div>
          <Button type="submit">Ingresar</Button>
        </div>
      </form>
    </div>
  );
}
