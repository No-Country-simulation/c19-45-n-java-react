import { IoIosFemale, IoIosMale } from "react-icons/io";
import Image from "next/image";
import { PET_SEX } from "../constants";

interface IPetBig {
  name: string;
  picture: string;
  age: string;
  specie: string;
  sex: string;
}

export const BannerPet = ({ name, picture, age, specie, sex }: IPetBig) => {
  return (
    <aside className="bg-[#FFCD82] p-10 rounded-lg shadow-l flex gap-16 items-center">
      <Image
        src={picture}
        width={250}
        height={100}
        alt="Mascota"
        className="w-[400px] object-cover rounded-md shadow-lg"
      />
      <div className="w-full">
        <div className="flex justify-between items-start">
          <div>
            <h1 className="text-6xl font-bold mb-1">{name}</h1>
            <p className="text-4xl ml-4">2 años</p>
          </div>
          <div className="bg-[#FFAC31] border-4 border-black p-3 rounded-full">
            {sex == PET_SEX.FEMALE && <IoIosFemale size={42} />}
            {sex == PET_SEX.MALE && <IoIosMale size={42} />}
          </div>
        </div>
        <div className="grid grid-cols-2 mt-6 gap-2 ml-4">
          <p className="text-2xl">
            <span className="uppercase font-bold">especie: </span>
            {age}
          </p>
          <p className="text-2xl uppercase">
            <span className=" font-bold">raza:</span> {specie}
          </p>
          <p className="text-2xl">
            <span className="uppercase font-bold">vacunas al día:</span>
            Si
          </p>
          <p className="text-2xl">
            <span className="uppercase font-bold">esterilización:</span>
            Si
          </p>
        </div>
      </div>
    </aside>
  );
};
