using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lecture1DemoTickle
{
        /* Simon, April 2015
         * Last updated August 2021
         * Demonstration for first Inft2012 lecture
         * Based on an idea by David Foster */

    public partial class FrmTickle : Form
    {   // These are instance (class-level) variables, because they are needed in multiple methods
        int iPresscount = 0;
        string sTitle = "Tee hee!";
        string sResponse = "Ooh, that tickles!";

        public FrmTickle()
        {   // The standard inbuilt initialising method
            InitializeComponent();
        }

        private void BtnTouchMe_Click(object sender, EventArgs e)
        {   // An event handler that responds to the button being clicked
            // When the button is pressed, add 1 to the counter
            iPresscount = iPresscount + 1;
            // If the counter registers 4 or 5 presses, change the reaction
            if (iPresscount==4)
            {
                ChangeReaction();
            }
            else if (iPresscount==5)
            {
                DisableButton();
            }
            // Enabling a timer starts it ticking, and each tick triggers
            // its event handler
            TmrShiver.Enabled = true;
            // Show the reaction in a message box
            MessageBox.Show(sResponse, sTitle);
            // We get to this point when the message box is OK'd. Stop the timer ticking.
            TmrShiver.Enabled = false;
        }

        private void ChangeReaction()
        {   // A method that is called on after 4 presses of the button
            // Too much tickling isn't good for you.
            // Change the response messages
            sTitle = "No more!";
            sResponse = "Ow! Now it hurts!";
            // And change some properties of the button
            BtnTouchMe.Text = "Don't touch!";
            BtnTouchMe.BackColor = Color.Yellow;
            BtnTouchMe.ForeColor = Color.Red;
        }

        private void DisableButton()
        {   // A method that is called on after 5 presses of the button
            // Not everyone knows when to stop tickling.
            // Change the response messages
            sTitle = "Now I'm angry!";
            sResponse = "I told you to stop!";
            // Display a new message, and resize and relocate the button to hold it
            BtnTouchMe.Width = BtnTouchMe.Width + 60;
            BtnTouchMe.Left = BtnTouchMe.Left - 30;
            BtnTouchMe.Height = BtnTouchMe.Height + 30;
            BtnTouchMe.Top = BtnTouchMe.Top - 15;
            BtnTouchMe.Text = "What bit of 'No' do you not understand?";
            // And disable the button
            BtnTouchMe.Enabled = false;
        }

        private void TmrShiver_Tick(object sender, EventArgs e)
        {   // An event handler that responds to each tick of tmrShiver
            // At every tick of the timer, move the form a little;
            // It will appear to be shivering
            // This variable is a random-number generator
            Random rand = new Random();
            int iMove;
            // Get a random number between -4 and 5
            iMove = rand.Next(-50, 50);
            // Move the top location of the form by that amount
            this.Top = this.Top + iMove;
            // Get another random number and move the left location of the form
            iMove = rand.Next(-50, 50);
            this.Left = this.Left + iMove;

        }

        private void FrmTickle_Load(object sender, EventArgs e)
        {

        }
    }
}
