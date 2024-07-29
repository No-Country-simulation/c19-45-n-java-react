import { IoLogoGithub, IoLogoLinkedin } from "react-icons/io5";

interface IMember {
  name: string;
  role: string;
  github: string;
  linkedin: string;
}

export const Member = ({ name, role, github, linkedin }: IMember) => {
  return (
    <div className="bg-[#FFCD82] p-6 rounded-lg shadow-lg w-full flex flex-col items-center">
      <div className="avatar mb-4">
        <div className="w-20 rounded-full">
          <img src="https://placehold.co/80x80" />
        </div>
      </div>
      <div className="flex gap-4 items-center">
        {github && <IoLogoGithub size={35} className="cursor-pointer" />}
        {linkedin && <IoLogoLinkedin size={35} className="cursor-pointer" />}
      </div>
      <div className="p-4 text-center">
        <p className="text-2xl font-semibold">{name}</p>
        <p className="text-gray-800">{role}</p>
      </div>
    </div>
  );
};
