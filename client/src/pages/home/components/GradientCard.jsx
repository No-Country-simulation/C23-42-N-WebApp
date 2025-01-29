import React, { useEffect, useState } from "react";
import { Vibrant } from "node-vibrant/browser";

export const GradientCard = ({ children, image }) => {
  const [gradient, setGradient] = useState("");

  useEffect(() => {
    const imgSrc = image;

    Vibrant.from(imgSrc)
      .getPalette()
      .then((palette) => {
        const vibrantSwatch = palette.Vibrant;
        const darkMutedSwatch = palette.DarkMuted;
        console.log(vibrantSwatch, "vibrantSwatch");
        console.log(darkMutedSwatch._rgb, "darkMutedSwatch");
        if (vibrantSwatch && darkMutedSwatch) {
          setGradient(
            `linear-gradient(to right, rgb(${vibrantSwatch._rgb.join(",")}), rgb(${darkMutedSwatch._rgb.join(",")}))`,
          );
        }
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      <div
        style={{
          width: "170px",
          background: gradient,
        }}
        className="rounded-3xl cursor-pointer"
      >
        {children}
      </div>
    </div>
  );
};
