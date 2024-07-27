"use client";
import { Button, Input, Label } from "../../modules/pets/components/ui/auth";
import { useForm, SubmitHandler } from "react-hook-form";

import Link from 'next/link'

interface FormValues {
  name: string;
  email: string;
  password: string;
  confirmPassword: string;
  // Agrega aquí los otros campos de tu formulario
}

  export default function ViewPetsRegister() {
    
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
        <ul className="menu menu-vertical m-5 text-2xl text-bold lg:menu-horizontal bg-orange-300 rounded-box ">
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
              <Label htmlFor="name">Nombre completo *</Label>
            </div>
            <div className="mt-2">
            <Input
                name="name"
                register={register}
                placeholder="   Ingresar nombre completo"
                required
              />
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="email">Correo Electronico *</Label>
            </div>
            <div className="mt-2">
            <Input
                name="email"
                register={register}
                placeholder="   Ingresar correo electronico"
              />
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="password">Contraseña *</Label>
            </div>
            <div className="mt-2">
            <Input
                type="password"
                name="password"
                register={register}
                placeholder="Escribe tu contraseña"
              />
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="password">Confirmar Contraseña *</Label>
            </div>
            <div className="mt-2">
            <Input
                type="password"
                name="confirmPassword"
                register={register}
                placeholder="Escribe tu contraseña"
              />
            </div>
          </div>
          <div>
            <Button type="submit">siguiente</Button>
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
