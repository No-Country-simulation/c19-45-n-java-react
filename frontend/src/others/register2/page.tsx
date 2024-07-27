"use client";
import { Button, Input, Label } from "../modules/pets/components/ui/auth";
import { useForm } from "react-hook-form";
import Link from "next/link";

function Register2() {
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
        <ul className="menu menu-vertical m-5 text-2xl text-bold sm:menu-horizontal bg-orange-300 rounded-box ">
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
              <Label htmlFor="name">Sexo *</Label>
            </div>
            <select className="select w-full max-w-xs">
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
                id="file"
                type="file"
                required
                autoComplete="email"
                placeholder="   Subir foto"
                {...register("foto")}
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
                ></textarea>
              </label>
            </div>
          </div>
          <div>
            <Link href="/listado">
              <Button type="submit">Registrarme</Button>
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

export default Register2;
