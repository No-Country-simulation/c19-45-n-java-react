"use client";
import { Button, Input, Label } from "../../modules/pets/components/ui/auth";
import { useForm, SubmitHandler } from "react-hook-form";

import Link from "next/link";

interface FormValues {
  sexo: string;
  photo: string;
  description: string;
  
  // Agrega aquí los otros campos de tu formulario
}

export default function ViewPetRegister2() {
 
  const { register, handleSubmit } = useForm<FormValues>();
  
  const onSubmit: SubmitHandler<FormValues> = (data) => {
    console.log(data); //en data sale toda la informacion del registro
  };


  return (
    <div className="bg-orange-200 flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-md text-center">
        <h2 className="text-5xl font-bold leading-9 tracking-tight text-gray-900 mb-10">
          Crear cuenta
        </h2>
        <ul className="menu menu-vertical m-5 text-2xl text-bold sm:menu-horizontal bg-orange-300 rounded-box ">
          <li>
            <a>Basica</a>
          </li>
          <li>
            <a>Contacto</a>
          </li>
        </ul>
        <form onSubmit={handleSubmit(onSubmit)}>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="name">Sexo *</Label>
            </div>
            <select 
              className="select w-full max-w-xs"
              {...register("sexo")}
              >
              <option disabled selected>
                Seleccione
              </option>
              <option>Macho</option>
              <option>Hembra</option>
             
            </select>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="file">Foto de perfil (opcional)</Label>
            </div>
            <div className="mt-2">
            <Input
                name="photo"
                register={register}
                placeholder="   Ingresar nombre completo"
                type="file"
              />  
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="password">Descripcion (opcional)</Label>
            </div>
            <div className="mt-2">
              <label className="form-control">
                <textarea
                  className="textarea textarea-bordered h-24"
                  placeholder="   Ingresar descripción"
                  {...register("description")}
                ></textarea>
              </label>
            </div>
          </div>
          <div>          
              <Button type="submit">Registrarme</Button>           
          </div>
        </form>
        <Link
          href="/login"
          className="block w-full underline text-xl text-black mt-4"
        >
          Ya tengo cuenta
        </Link>
      </div>
    </div>
  );
}

