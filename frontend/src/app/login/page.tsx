"use client"
import { Button, Input, Label } from "../../modules/pets/components/ui/auth";
import { useForm } from "react-hook-form";
import Link from 'next/link'

export default function ViewPetsLogin() {


  const { register, handleSubmit } = useForm();

  const onSubmit = handleSubmit ((data) => {
    console.log(data); //en data tiene todos los datos del formulario
  });
  
    return (
      <div className="bg-orange-200 flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-md text-center">
          <h2 className="text-6xl font-bold leading-9 tracking-tight text-gray-900 mb-10">
            Inicio de Sesión
          </h2>
          <a href="#" className="block w-full underline text-xl text-black mb-4">Olvide mi contraseña</a>
  
          <form onSubmit={onSubmit} action="#" method="POST" className="space-y-6">
            <div>
              <div className="flex items-center justify-between">
                <Label htmlFor="email">Correo Electronico :</Label>
              </div>
              <div className="mt-2">
                <Input
                id="email"
                type="email"
                required
                autoComplete="email"
                placeholder="   Ingresar correo" 
                {...register("email")}
                />
              </div>
            </div>
  
            <div>
              <div className="flex items-center justify-between">
               <Label htmlFor="password">Contraseña :</Label>
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
              <Link href="/register">
            <Button type="submit">Ingresar</Button> 
              </Link>
            </div>
          </form>
          <Link href="/register"  className="block w-full underline text-xl text-black mt-4">Registrarme</Link>
        </div>
      </div>
    );
  }