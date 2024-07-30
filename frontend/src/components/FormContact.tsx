import { PEOPLE_GENDER } from "@/constants";
import { BtnUpload, Select, Textarea } from ".";

export const FormContact = () => {
  return (
    <>
      <Select
        label="Genero*"
        placeholder="Seleccione genero"
        options={PEOPLE_GENDER}
      />
      <BtnUpload label="Foto de Perfil (opcional)" />
      <Textarea
        label="Descripción (opcional)"
        placeholder="Ingrese una descripción"
      />
    </>
  );
};
