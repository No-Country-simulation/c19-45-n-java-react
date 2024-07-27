"use client";
import { Button, Input, Label } from "../../modules/pets/components/ui/auth";
import { useForm, SubmitHandler } from "react-hook-form";
import Link from "next/link";

interface FormValues {
  email: string;
  password: string;
  // Agrega aquí los otros campos de tu formulario
}

export default function ViewPetsLogin() {
  const { register, handleSubmit } = useForm<FormValues>();

  const onSubmit: SubmitHandler<FormValues> = (data) => {
    console.log(data); //en data sale toda la informacion del registro
  };

  return (
    <div className="bg-orange-200 flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-md text-center">
        <h2 className="text-6xl font-bold leading-9 tracking-tight text-gray-900 mb-10">
          Inicio de Sesión
        </h2>
        <a href="#" className="block w-full underline text-xl text-black mb-4">
          Olvide mi contraseña
        </a>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="email">Correo Electronico :</Label>
            </div>
            <div className="mt-2">
              <Input
                name="email"
                register={register}
                placeholder="Escribe tu correo"
                required
              />
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <Label htmlFor="password">Contraseña :</Label>
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
            <Button type="submit">Ingresar</Button>
          </div>
        </form>
        <Link
          href="/register"
          className="block w-full underline text-xl text-black mt-4"
        >
          Registrarme
        </Link>
      </div>
    </div>
  );
}
