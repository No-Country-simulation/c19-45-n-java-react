"use client";
import Boton from "@/modules/pets/components/ui/list/Boton";
import Hero from "../../modules/pets/components/ui/list/Hero";
import Listcard from "@/modules/pets/components/ui/list/Listcard";
import ListModal from "@/modules/pets/components/ui/list/Modal";
import { BiLogoBaidu } from "react-icons/bi";
import { FaDog } from "react-icons/fa";
import { LiaCatSolid } from "react-icons/lia";

function Listado() {
  const handleButtonClick = () => {
    alert("Button clicked!");
  };

  return (
    <div className="bg-orange-200 ">
      <div className="flex min-h-full items-start justify-center px-6 py-12 lg:px-8">
        <Hero />
      </div>
      <div className="flex flex-row justify-around">
        <h2 className="flex text-3xl font-bold ml-10 p-6">Especies</h2>
        <ListModal
        modalId="my_modal_1"
        title="Filtro"
        buttonText="Filtrar"
        closeButtonText="Close"
      />
      </div>
      <div className="flex items-center justify-center">
        <Boton icon={<BiLogoBaidu className="w-20 h-20 mr-2" />}>Todos</Boton>
        <Boton icon={<FaDog className="w-20 h-20 mr-2" />}>Perros</Boton>
        <Boton icon={<LiaCatSolid className="w-20 h-20 mr-2" />}>Gatos</Boton>
      </div>
      <div className="flex flex-col">
        <h2 className="flex text-3xl font-bold ml-52 p-6 m-4">
          Mascotas encontradas
        </h2>
      </div>
      <div className=" flex flex-wrap items-center justify-center">
        <Listcard
          imageSrc="/imagen-02.png"
          title="Gringo"
          sexo="Macho"
          edad="2"
          description="jugeton, se la pasa durmiendo y comiendo"
          buttonText="Conocer"
          onButtonClick={handleButtonClick}
        />
        <Listcard
          imageSrc="/imagen-02.png"
          title="Fido"
          sexo="Hembra"
          edad="3"
          description="jugeton, se la pasa durmiendo y comiendo"
          buttonText="conocer"
          onButtonClick={() => console.log("Adoptar button clicked")}
        />
         <Listcard
          imageSrc="/imagen-02.png"
          title="Luna"
          sexo="Hembra"
          edad="4"
          description="jugeton, se la pasa durmiendo y comiendo"
          buttonText="Conocer"
          onButtonClick={handleButtonClick}
        />
      </div>
    </div>
  );
}

export default Listado;
