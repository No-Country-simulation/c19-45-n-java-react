"use client";
import { Button, Input, Label } from "../../modules/pets/components/ui/auth";
import { useForm } from "react-hook-form";
import Link from 'next/link'

export default function Register() {
  const { register, handleSubmit } = useForm();

  const onSubmit = handleSubmit((data) => {
    console.log(data); //en data tiene todos los datos del formulario
  });

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
        <form
          onSubmit={onSubmit}
          action="#"
          method="POST"
          className="space-y-6"
        >
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="name">Nombre completo *</Label>
            </div>
            <div className="mt-2">
              <Input
                id="name"
                type="text"
                required
                autoComplete="name"
                placeholder="   Ingresar nombre completo"
                {...register("name")}
              />
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="email">Correo Electronico *</Label>
            </div>
            <div className="mt-2">
              <Input
                id="email"
                type="email"
                required
                autoComplete="email"
                placeholder="   Ingresar correo electronico"
                {...register("email")}
              />
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="password">Contraseña *</Label>
            </div>
            <div className="mt-2">
              <Input
                id="password"
                type="password"
                required
                autoComplete="current-password"
                placeholder="   Ingresar su contraseña"
                {...register("password")}
              />
            </div>
          </div>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="password">Confirmar Contraseña *</Label>
            </div>
            <div className="mt-2">
              <Input
                id="password2"
                type="password2"
                required
                autoComplete="current-password"
                placeholder="   Ingresar su contraseña"
                {...register("password2")}
              />
            </div>
          </div>
          <div>
            <Link href="/register2" >
            <Button type="submit">siguiente</Button>
            </Link>
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
