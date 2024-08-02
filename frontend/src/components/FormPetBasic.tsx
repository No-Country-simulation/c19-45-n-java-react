"use client";

import { PET_AGES, PET_SEX_ALL, PET_SPECIES_ALL } from "@/constants";
import { Input, Select } from ".";
import { useSearchParams } from "next/navigation";

export const FormPetBasic = () => {
  const searchParams = useSearchParams();
  const params = new URLSearchParams(searchParams);

  const action = params.get("accion") ?? "crear-mascota";
  const isCreated = action === "crear-mascota";
  return (
    <section className="my-14">
      <h1 className="text-4xl font-semibold mb-6">Básico</h1>

      <div className="flex flex-col gap-6">
        <Input
          value={isCreated ? "" : "Gringo"}
          label="Nombres*"
          type="text"
          placeholder="Ingresar nombres"
        />
        <Select
          label="Especie*"
          placeholder="Seleccione especie"
          value={isCreated ? "" : "dog"}
          options={PET_SPECIES_ALL}
        />
        <Input label="Raza*" type="text" placeholder="Ingresar raza" />
        <Select
          label="Edad*"
          placeholder="Seleccione edad"
          value={isCreated ? "" : "2"}
          options={PET_AGES}
        />
        <Select
          label="Sexo*"
          placeholder="Seleccione sexo"
          options={PET_SEX_ALL}
          value={isCreated ? "" : "male"}
        />
      </div>
    </section>
  );
};
