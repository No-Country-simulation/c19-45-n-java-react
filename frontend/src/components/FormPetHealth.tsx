"use client";

import { useSearchParams } from "next/navigation";
import { Select } from ".";

export const FormPetHealth = () => {
  const searchParams = useSearchParams();
  const params = new URLSearchParams(searchParams);

  const action = params.get("accion") ?? "crear-mascota";
  const isCreated = action === "crear-mascota";
  return (
    <section className="my-14">
      <h1 className="text-4xl font-semibold mb-6">Salud</h1>
      <div className="flex flex-col gap-6">
        <Select
          label="Vacunas al día*"
          placeholder="Seleccione"
          value={isCreated ? "" : "yes"}
          options={[
            {
              value: "yes",
              label: "Si",
            },
            {
              value: "no",
              label: "No",
            },
          ]}
        />
        <Select
          value={isCreated ? "" : "yes"}
          label="Esterelización*"
          placeholder="Seleccione"
          options={[
            {
              value: "yes",
              label: "Si",
            },
            {
              value: "no",
              label: "No",
            },
          ]}
        />
      </div>
    </section>
  );
};
